package com.gmail.schcrabicus.prospring3.tutorials.ch5.lifecycle.propertyEditors.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: schcrabicus
 * Date: 11.01.13
 * Time: 8:08
 * To change this template use File | Settings | File Templates.
 */
public class PropertyEditorBean {

    private byte[] bytes;   // ByteArrayPropertyEditor

    private Class cls;      // ClassEditor

    private Boolean trueOrFalse; // CustomBooleanEditor

    private List<String> stringList; // CustomCollectionEditor

    private Date date;      // CustomDateEditor          ---> have to configure manually !!!!

    private Float floatValue; // CustomNumberEditor

    private File file; // FileEditor

    private InputStream inputStream; // InputStreamEditor

    private Locale locale; // LocaleEditor

    private Pattern pattern; // PatternEditor

    private Properties properties; // Properties editor

    private String trimString;  // StringTrimmerEditor    ---> have to configure manually !!!!

    private URL url;            // UrlEditor

    public void setBytes(byte[] bytes) {
        System.out.println("Adding " + bytes.length + " bytes");
        this.bytes = bytes;
    }

    public void setCls(Class cls) {
        System.out.println("Setting class : " + cls.getName());
        this.cls = cls;
    }

    public void setTrueOrFalse(Boolean trueOrFalse) {
        System.out.println("Setting trueOrFalse : " + trueOrFalse);
        this.trueOrFalse = trueOrFalse;
    }

    public void setStringList(List<String> stringList) {
        System.out.println("Setting string list with size: "
                + stringList.size());
        this.stringList = stringList;
        for (String string: stringList) {
            System.out.println("String member: " + string);
        }
    }

    public void setDate(Date date) {
        System.out.println("Setting date : " + date);
        this.date = date;
    }

    public void setFloatValue(Float floatValue) {
        System.out.println("Setting floatValue : " + floatValue);
        this.floatValue = floatValue;
    }

    public void setFile(File file) {
        System.out.println("Setting file: " + file.getName());
        this.file = file;
    }

    public void setInputStream(InputStream inputStream) {
        System.out.println("Setting stream: " + inputStream);
        this.inputStream = inputStream;
    }

    public void setLocale(Locale locale) {
        System.out.println("Setting locale : " + locale.getDisplayName());
        this.locale = locale;
    }

    public void setPattern(Pattern pattern) {
        System.out.println("Setting pattern: " + pattern);
        this.pattern = pattern;
    }

    public void setProperties(Properties properties) {
        System.out.println("Loaded " + properties.size() + " properties");
        this.properties = properties;
    }

    public void setTrimString(String trimString) {
        System.out.println("Setting trim string: " + trimString);
        this.trimString = trimString;
    }

    public void setUrl(URL url) {
        System.out.println("Setting URL: " + url.toExternalForm());
        this.url = url;
    }

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:**/ch5/lifecycle/propertyEditors/xml/spring-app.xml");

        PropertyEditorBean bean = ctx.getBean("propertyEditorBean", PropertyEditorBean.class);
    }
}
