package Assignment01;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class CreepBugPre_HUST implements PageProcessor{

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
                    .xpath("//div[@class='js_bt']//").links().all();
            page.addTargetRequests(Links);
            doAdd = true;
        }
        else{
            String m_Name = page.getHtml().xpath("//div[@class='info']/h2/text()").toString();
            String m_Sex = page.getHtml().xpath("div[@class='cont']/p/text()").all().get(1);
            String m_Major = page.getHtml().xpath("div[@class='cont']/p/text()").all().get(0);
            String m_Res = page.getHtml().xpath("div[@class='cont']/text()").toString().split(" +")[1];
            TeacherInfo info = new TeacherInfo(m_Name,m_Sex,m_Major,m_Res);
             infos.add(info);
             info.ShowInfo();

        }
    }

    /*public static void main(String[] args) {
        Spider.create(new CreepBugPre_HUST()).addUrl("http://cs.hust.edu.cn/szdw/jsml/axmpyszmlb.htm").addPipeline(new ConsolePipeline()).thread(16).run();


    }*/
}
