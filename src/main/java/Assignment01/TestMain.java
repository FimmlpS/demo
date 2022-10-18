package Assignment01;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;

public class TestMain {

    public static void main(String[] args) {
        //武汉大学教授列表
        Spider.create(new CreepBugPre()).addUrl("http://cs.whu.edu.cn/teacher.aspx?showtype=jobtitle&typename=%e6%95%99%e6%8e%88").addPipeline(new ConsolePipeline()).run();
        //华中科技大学列表
        //Spider.create(new CreepBugPre_HUST()).addUrl("http://cs.hust.edu.cn/szdw/jsml/axmpyszmlb.htm").addPipeline(new ConsolePipeline()).thread(16).run();
        //海南大学教师列表
        //Spider.create(new CreepBugPre_HNU()).addUrl("https://hd.hainanu.edu.cn/cs/xygk/szdw.htm").addPipeline(new ConsolePipeline()).thread(16).run();
    }
}
