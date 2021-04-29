package service.impl;

import dao.UserMessageMapper;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.UserMessage;
import result.CodeMsg;
import result.Result;
import service.UserMessageService;
import util.QiniuUploadUtil;
import vo.UserVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;


@Service("UserMessageService")
public class UserMessageServiceImpl implements UserMessageService {
    @Autowired
    UserMessageMapper userMessageMapper;

    @Override
    public UserMessage select(Long userId) {
        return userMessageMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Result<Boolean> register(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("this is start!");
        response.setContentType("text/html");
//		response.setCharacterEncoding("utf-8");
        UserMessage userMessage = new UserMessage();

        //这种方法主要通过if (item.isFormField())这个条件判别文件还是非文件
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List items = null;
        try {
         items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        } // 解析request请求
        Iterator iter = items.iterator();// 遍历表单中提交过来的内容
        int cout=0;
        while (iter.hasNext()) {

            System.out.println(cout++);
            FileItem item = (FileItem) iter.next();
            if (item.isFormField()) { // 如果是表单域 ，就是非文件上传元素
                String value = null; // 获取value属性的值，这里需要指明UTF-8格式，否则出现中文乱码问题
                try {
                    value = item.getString("UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                System.out.println(item.getFieldName());
                if (item.getFieldName().equals("userName")) {// 对应form中属性的名字
                    userMessage.setUserName(value);
                } else if (item.getFieldName().equals("userAge")) {
                    Short userAge = Short.parseShort(value);
                    userMessage.setUserAge(userAge);
                } else if (item.getFieldName().equals("userPhone")) {
                    Long userPhone = Long.parseLong(value);
                    userMessage.setUserPhone(userPhone);
                } else if (item.getFieldName().equals("userPassword")) {
                    userMessage.setUserPassword(value);
                    System.out.println("!???????????????!");
                }
            }
            else {
                    System.out.println("!!!!!!!!!!!!!!");
                    String filename = item.getName(); // 文件的名字
                    String imgname = filename.substring(0, filename.indexOf("."));  //减去“.”后面的字符
                    System.out.println("filename:"+filename+"\n"+"imgname:"+imgname);
                    //tomcat启动位置
//				String t1 = System.getProperty("user.dir").substring(0,
//						System.getProperty("user.dir").length() - 4);
                    String path = request.getServletContext().getRealPath("/"); //target找到img位置
                System.out.println("path:"+path);


                    Long time = Calendar.getInstance().getTimeInMillis();  //时间戳，保证文件命名不重复
//                    String imgurl = "./img/" + imgname + time + ".jpg";
                String name = imgname + time;
//                    userMessage.setUserImg(QiniuUploadUtil.UploadPic(path,name));
                    System.out.println("name:"+name);
//
                    File saveFile = new File(path + "/" + imgname + time + ".jpg"); // 定义一个file指向一个具体的文件

                    try {
                        item.write(saveFile);// 把上传的内容写到一个文件中
                        System.out.println("上传到" + path + "成功");
                        userMessage.setUserImg(QiniuUploadUtil.UploadPic(saveFile.getPath(),saveFile.getName()));
                        System.out.println(userMessage.getUserImg());
                        saveFile.delete();

                    } catch (Exception e) {
                        /* e.printStackTrace(); */
                        System.out.println("文件" + path + "为空");
                    }
                }
            }

        if(userMessageMapper.selectByPrimaryKey(userMessage.getUserId())==null){
            int result = userMessageMapper.insert(userMessage);
            if(result==0){
                return Result.error(CodeMsg.REGISTER_ERROR);
            }
            else{
                return Result.success(true);
            }
        }
        else{
            return Result.error(CodeMsg.USER_EXISTED);
        }

    }


    @Override
    public Result<Boolean> checkUser(UserVo userVo) {
        UserMessage userMessage = userMessageMapper.selectByPrimaryKey(userVo.getUserId());
        System.out.println("id:"+userMessage.getUserId()+",password:"+userMessage.getUserPassword());
        if(userMessage==null){
            return Result.error(CodeMsg.USER_NOT_EXIST);
        }
        else if(!userMessage.getUserPassword().equals(userVo.getUserPassword())){
            return Result.error(CodeMsg.PASSWORD_ERROR);
        }
        return Result.success(true);
    }

}
