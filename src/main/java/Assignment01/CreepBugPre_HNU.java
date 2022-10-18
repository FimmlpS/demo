package Assignment01;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class CreepBugPre_HNU implements PageProcessor{

    //教师列表
    List<TeacherInfo> infos = new ArrayList<>();

    //
    private Site site = Site.me();

    @Override
    public Site getSite(){
        return site;
    }

    boolean doAdd = false;

    @Override
    public void process(Page page){
        if(!doAdd){
            List<String> Links = page.getHtml()
                    .xpath("//div[@class='m_newyi']//").links().all();

            page.addTargetRequests(Links);
            doAdd = true;
        }
        else{
            String m_Name = page.getHtml().xpath("//div[@class='ren_mu']/ul/li/b/text()").toString();

            String m_Sex = null;
            String m_Major = page.getHtml().xpath("//div[@class='ren_mu']/ol/li/i/text()").all().get(1);
            String m_Res = null;
            TeacherInfo info = new TeacherInfo(m_Name,m_Sex,m_Major,m_Res);
            infos.add(info);
            info.ShowInfo();

        }
    }

    public static void main(String[] args) {
        Spider.create(new CreepBugPre_HNU()).addUrl("https://hd.hainanu.edu.cn/cs/xygk/szdw.htm").addPipeline(new ConsolePipeline()).thread(16).run();


    }
}
