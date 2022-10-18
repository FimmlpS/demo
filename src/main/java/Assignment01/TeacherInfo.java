package Assignment01;

public class TeacherInfo {

    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    String sex;

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    String major;

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    String res;

    public void setRes(String res) {
        this.res = res;
    }

    public String getRes() {
        return res;
    }

    public TeacherInfo(String name,String sex,String major,String res){
        setName(name);
        setSex(sex);
        setMajor(major);
        setRes(res);
    }

    public void ShowInfo(){
        System.out.println( "姓名： "+name);
        System.out.println( "性别： "+sex);
        System.out.println( "职称： "+major);
        System.out.println( "研究方向： "+res);
    }
}
