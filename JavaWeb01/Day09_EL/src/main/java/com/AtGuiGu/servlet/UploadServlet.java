package com.AtGuiGu.servlet;





import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/12-16:43
 */

public class UploadServlet extends HttpServlet {
    /**
     * 用来处理上传数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 先判断上传的数据是否多段数据 (只有多段的数据才是文件上传)
        if(ServletFileUpload.isMultipartContent(req)){
            //创建FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            try {
                //解析上传的数据, 得到每一个表单项 FileItem
                List<FileItem> list = servletFileUpload.parseRequest(req);
                //循环判断 每一个表单项 是普通类型还是上传的文件
                for(FileItem fileItem : list){
                    //普通
                    if(fileItem.isFormField()){
                        System.out.println("表单项的name属性值: "+fileItem.getFieldName());
                        System.out.println("表单项的value属性值: "+fileItem.getString("UTF-8"));
                    }else{
                        //上传的文件
                        System.out.println("表单项的name属性值: "+fileItem.getFieldName());
                        System.out.println("上传的文件名: "+fileItem.getName());
                        fileItem.write(new File("D:\\"+fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
