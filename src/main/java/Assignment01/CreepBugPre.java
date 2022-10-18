package Assignment01;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class CreepBugPre implements PageProcessor {

    //教师列表
    List<TeacherInfo> infos = new ArrayList<>();

    //
    private Site site = Site.me();

    @Override
    public Site getSite(){
        return site;
    }

    @Override
    public void process(Page page) {
        System.out.println("Process0");
        List<String> names = doTeacherNamePro(page);
        List<String> sexs = doTeacherSexPro(page);
        List<String> majors = doTeacherMajorPro(page);
        List<String> ress = doTeacherResPro(page);

        //正则好难，寄
        for(int i=0;i<names.size()&&i<sexs.size()&&i<majors.size()&&i<ress.size();i++){
            infos.add(new TeacherInfo(names.get(i),sexs.get(i),majors.get(i),ress.get(i)));
        }

        ShowListSample(17);
    }

    public void ShowListSample(int index){
        infos.get(index).ShowInfo();
    }

    //获取所有教师名
    private List<String> doTeacherNamePro(Page page){
        //Thread.sleep(1000);
        System.out.println("Process1");


        List<String> teacherNamesRequest = page.getHtml()
                .xpath("//td[@class='w1']/a/text()").all();

        //谢谢你，武带
        teacherNamesRequest.add(0,"姓名");

        /*for(int i =0;i<teacherNamesRequest.size();i++)
        {
            System.out.println(teacherNamesRequest.get(i));
        }*/

        return teacherNamesRequest;
    }

    //获取性别
    private List<String> doTeacherSexPro(Page page){
        System.out.println("Process2");

        List<String> teacherSexsRequest = page.getHtml()
                .xpath("//td[@class='w2']/text()").all();

        /*for(int i =0;i<teacherSexsRequest.size();i++)
        {
            System.out.println(teacherSexsRequest.get(i));
        }*/

        return teacherSexsRequest;
    }
    //获取职称
    private List<String> doTeacherMajorPro(Page page){
        System.out.println("Process3");

        List<String> teacherMajorsRequest = page.getHtml()
                .xpath("//td[@class='w4']/text()").all();

        /*for(int i =0;i<teacherMajorsRequest.size();i++)
        {
            System.out.println(teacherMajorsRequest.get(i));
        }*/

        return teacherMajorsRequest;
    }
    //获取研究方向
    private List<String> doTeacherResPro(Page page){
        System.out.println("Process4");

        List<String> teacherRessRequest = page.getHtml()
                .xpath("//td[@class='w5']/text()").all();

        /*for(int i =0;i<teacherRessRequest.size();i++)
        {
            System.out.println(teacherRessRequest.get(i));
        }*/

        return  teacherRessRequest;
    }


    /*public static void main(String[] args) {
        Spider.create(new CreepBugPre()).addUrl("http://cs.whu.edu.cn/teacher.aspx?showtype=jobtitle&typename=%e6%95%99%e6%8e%88").addPipeline(new ConsolePipeline()).run();
    }*/

}
