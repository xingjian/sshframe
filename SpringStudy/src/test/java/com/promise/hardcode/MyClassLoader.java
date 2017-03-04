/** @文件名: MyClassLoader.java @创建人：邢健  @创建日期： 2015年8月1日 下午6:27:37 */
package com.promise.hardcode;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**  
 * @类名: MyClassLoader.java
 * @包名: com.promise.hardcode
 * @描述: TODO
 * @作者: xingjian xingjian@yeah.net  
 * @日期:2015年8月1日 下午6:27:37
 * @版本: V1.0  
 */
@SuppressWarnings("all")
public class MyClassLoader extends ClassLoader{

	public static void main(String[] args) throws Exception {
        String srcPath = args[0];
        String destDir = args[1];
        FileInputStream fis = new FileInputStream(srcPath);
        String destFileName = srcPath.substring(srcPath.lastIndexOf('\\')+1);
        String destPath = destDir + "\\" + destFileName;
        FileOutputStream fos = new FileOutputStream(destPath);
        cypher(fis,fos);
        fis.close();
        fos.close();
    }
 
    /**
     * 加密方法,同时也是解密方法
     * @param ips
     * @param ops
     * @throws Exception
     */
    private static void cypher(InputStream ips ,OutputStream ops) throws Exception{
        int b = -1;
        while((b=ips.read())!=-1){
            ops.write(b ^ 0xff);//如果是1就变成0,如果是0就变成1
        }
    }
 
    private String classDir;
 
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classFileName = classDir + "\\" + name.substring(name.lastIndexOf('.')+1) + ".class";
        try {
            FileInputStream fis = new FileInputStream(classFileName);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            cypher(fis,bos);
            fis.close();
            System.out.println("aaa");
            byte[] bytes = bos.toByteArray();
            return defineClass(bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
 
    public MyClassLoader(){
    }
 
    public MyClassLoader(String classDir){
        this.classDir = classDir;
    }
	
}
