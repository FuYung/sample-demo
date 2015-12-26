package cn.dreamfy.email.entity;

/**
 * 复杂的邮箱(带附件)
 */
public class ComplexEmail extends SimpleEmail {

    /**
     * 附件地址
     */
    private String[] attchPaths;

    /**
     * 附件地址
     */
    private String[] attchNames;


    public String[] getAttchPaths() {
        return attchPaths;
    }

    public void setAttchPaths(String[] attchPaths) {
        this.attchPaths = attchPaths;
    }

    public String[] getAttchNames() {
        return attchNames;
    }

    public void setAttchNames(String[] attchNames) {
        this.attchNames = attchNames;
    }
}
