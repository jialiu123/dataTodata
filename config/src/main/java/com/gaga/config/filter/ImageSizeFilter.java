package com.gaga.config.filter;

import cn.hutool.core.io.FileUtil;
import com.gaga.utils.ImageChangeSize;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Liu, jia 图片尺寸过滤，根据尺寸要求创建并返回新尺寸地址
 * @s400x400 表示切图400x400的
 * @compress 表示图片压缩
 */
@WebFilter(urlPatterns = "/file/*")
public class ImageSizeFilter extends OncePerRequestFilter {

    private static final String IMAGE_EXT = "png,jepg,jpg";

    @Value("${file-manage.upload.root-dir}")
    private String uploadPath;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String return_url = request.getServletPath();
        return_url = return_url.replace("/file", "");
        String desc = null;

        //这个地方可以在剥离出来，算了，我就不弄了
        //可以使用工厂模式 并且使用工程使用面向接口编程
        if (return_url.contains("@s")) {
            CutImageHandle cutImageHandle = new CutImageHandle(return_url, uploadPath);
            desc = cutImageHandle.handle(IMAGE_EXT);
        } else if (return_url.endsWith("@compress")) {
            CompressImageHandle compressImageHandle = new CompressImageHandle(return_url, uploadPath);
            desc = compressImageHandle.handle(IMAGE_EXT);
        }

        FileInputStream fis = null;
        response.setContentType("image/jped");
        try {
            OutputStream out = response.getOutputStream();
            File file = new File(desc);
            fis = new FileInputStream(file);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            out.write(b);
            out.flush();
            return;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        chain.doFilter(request, response);
    }


    class CompressImageHandle {

        private String source;

        private String desc;

        CompressImageHandle(String returnUrl, String uploadPath) {

            source = uploadPath + returnUrl.split("@compress")[0];

            desc = uploadPath + StringUtils.substringBeforeLast(source, ".") + "_compress" + "."
                    + FileUtil.extName(source);
        }


        public String handle(String IMAGE_EXT) {

            if (IMAGE_EXT.toLowerCase().contains(FileUtil.extName(source).toLowerCase())) {

                File file_source = new File(source);
                File file_temp = new File(desc);
                if (!file_temp.exists()) {
                    try {
                        long file_size = file_source.length();
                        if (file_size <= 102400) {
                            Thumbnails.of(file_source).scale(1f).toFile(file_temp);
                        } else {
                            Thumbnails.of(file_source).scale(1f).outputQuality(0.25f).toFile(file_temp);
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            return desc;
        }
    }


    class CutImageHandle {


        private String source;

        private String size;

        private int width;

        private int height;

        private String desc;

        CutImageHandle(String returnUrl, String uploadPath) {

            source = returnUrl.split("@s")[0];
            size = returnUrl.split("@s")[1];
            width = Integer.valueOf(size.split("x")[0]);
            height = Integer.valueOf(size.split("x")[1]);

            desc = StringUtils.substringBeforeLast(source, ".") + "_" + width + "x"
                    + height + "." + FileUtil.extName(source);

            source = uploadPath + source;

            desc = uploadPath + desc;
        }


        public String handle(String IMAGE_EXT) {

            if (IMAGE_EXT.toLowerCase().contains(FileUtil.extName(source).toLowerCase())) {
                try {
                    ImageChangeSize.compressImage(source, width, height);
                } catch (IOException e1) {
                    // 图片裁剪异常返回原图
                    desc = source;
                }
                File file_temp = new File(desc);
                // 得到图片
                BufferedImage src = ImageChangeSize.InputImage(source);
                if (null != src) {
                    // 得到源图宽
                    int old_w = src.getWidth();
                    // 得到源图长
                    int old_h = src.getHeight();

                    // 如果裁剪尺寸与原图一致，则返回原图
                    if (width == old_w && height == old_h) {
                        desc = source;
                    }
                }
            }
            return desc;
        }
    }

}




