package com.AtGuiGu.Xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/8-10:37
 */

public class Dom4jTest {

    @Test
    public void test1() throws Exception {
        //创建一个SaxReader输入流 读取xml配置文件 生成Document对象
        SAXReader saxReader = new SAXReader();
        Document doc = saxReader.read("src/books.xml");
        System.out.println(doc);
        
    }

    /**
     * 读取books.xml生成book类
     */
    @Test
    public void test2() throws Exception{
        //读取books.xml文件
        SAXReader saxReader = new SAXReader();
        // Junit中 相对路径从模块名开始算
        //通过document对象获取根元素
        Document document = saxReader.read("src/books.xml");
        Element rootElement = document.getRootElement();
//        System.out.println(rootElement);
        //通过根元素获取book标签对象
        //element elements() 都是通过标签名查找子元素
        List<Element> books = rootElement.elements("book");
        //遍历 处理每个book标签转换为book类
        for(Element book : books){
            //asXML()把标签对象转换为标签字符串
//            System.out.println(book.asXML());
            Element nameEle = book.element("name");
            String nameText = nameEle.getText();
            //直接获取指定标签名的文本内容
            String priceText = book.elementText("price");
            String authorText = book.elementText("author");
            String snValue = book.attributeValue("sn");
            System.out.println(new Book(snValue,nameText,Double.parseDouble(priceText),authorText));
        }
        
    }
}
