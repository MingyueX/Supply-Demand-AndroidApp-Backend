package org.practice.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.practice.model.*;
import org.practice.service.CategoryService;
import org.practice.service.LoginService;
import org.practice.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/hello")
public class AccountController {
    @Resource
    private LoginService loginService;
    @Resource
    private PostService postService;
    @Resource
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
    public String checkLogin(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        /*
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

         */

        Account account = loginService.HelloService(username);
        if (account == null || !account.getPassword().equals(password)) {
            //out.write("");
            return null;
        }
        return JSON.toJSONString(account);
        //String str = JSONObject.toJSONString(account);
        //out.write(str);
        //return str;
    }

    @ResponseBody
    @RequestMapping(value = "/getUser", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
    public String getUser(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("userId");
        Account account = loginService.getById(Integer.parseInt(id));
        return JSON.toJSONString(account);
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
    public String checkReg(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Account check = loginService.HelloService(username);


        /*
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

         */

        if (check != null){
            //out.write("");
            return null;
        }
        else {
            Account account = new Account();
            account.setUsername(username);
            account.setPassword(password);
            loginService.HelloSave(account);
            return JSONObject.toJSONString(account);
            //String str = JSONObject.toJSONString(account);
            //out.write(str);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String query(HttpServletRequest request, HttpServletResponse response) {
        String queryString = request.getParameter("queryPost");
        QueryPost queryPost = JSON.parseObject(queryString, QueryPost.class);
        if (!(queryPost.getCategoryIds() == null)) {
            String categories = ",";
            for (int i = 0; i < queryPost.getCategoryIds().size(); i++) {
                String cName = queryPost.getCategoryIds().get(i);
                int cateId = categoryService.getCid(cName);
                categories += String.valueOf(cateId);
                categories += ",";
            /*
            if (i != queryPost.getCategoryIds().size() - 1) {
                categories += ",";
            }

             */
            }
            queryPost.setAppendedCid(categories);
        }
        List<Post> posts = postService.selectAllSatisfied(queryPost);
        return JSONObject.toJSONString(posts);
    }

    @ResponseBody
    @RequestMapping(value = "/send", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
    public String sendPost(HttpServletRequest request, HttpServletResponse response) {
        String type = request.getParameter("type");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String country = request.getParameter("country");
        String province = request.getParameter("province");
        String city = request.getParameter("city");
        String lengthMin = request.getParameter("lengthMin");
        String lengthMax = request.getParameter("lengthMax");
        String widthMin = request.getParameter("widthMin");
        String widthMax = request.getParameter("widthMax");
        String heightMin = request.getParameter("heightMin");
        String heightMax = request.getParameter("heightMax");
        String weightMin = request.getParameter("weightMin");
        String weightMax = request.getParameter("weightMax");
        String price = request.getParameter("price");
        String stars = request.getParameter("stars");
        String uid = request.getParameter("uid");
        String categoryId = request.getParameter("categoryId");
        String quantity = request.getParameter("quantity");
        String delivery = request.getParameter("delivery");
        //String status = request.getParameter("status");

        Post post = new Post();
        post.setType(type);
        post.setTitle(title);
        post.setDescription(description);
        post.setCountry(country);
        post.setProvince(province);
        post.setCity(city);
        if (lengthMin != null && !lengthMin.equals("")) {
            post.setLengthMin(Integer.parseInt(lengthMin));
        }
        if (lengthMax != null && !lengthMax.equals("")) {
            post.setLengthMax(Integer.parseInt(lengthMax));
        }
        if (widthMin != null && !widthMin.equals("")) {
            post.setWidthMin(Integer.parseInt(widthMin));
        }
        if (widthMax != null && !widthMax.equals("")) {
            post.setWidthMax(Integer.parseInt(widthMax));
        }
        if (heightMin != null && !heightMin.equals("")) {
            post.setHeightMin(Integer.parseInt(heightMin));
        }
        if (heightMax != null && !heightMax.equals("")) {
            post.setHeightMax(Integer.parseInt(heightMax));
        }
        if (weightMin != null && !weightMin.equals("")) {
            post.setWeightMin(Double.parseDouble(weightMin));
        }
        if (weightMax != null && !weightMax.equals("")) {
            post.setWeightMax(Double.parseDouble(weightMax));
        }
        post.setPrice(new BigDecimal(price));
        post.setStars(Integer.parseInt(stars));
        post.setStars(Integer.parseInt(uid));
        if (categoryId != null && !categoryId.equals("")) {
            post.setCategoryId(Integer.parseInt(categoryId));
        }
        if (quantity != null && !quantity.equals("")) {
            post.setQuantity(Integer.parseInt(quantity));
        }
        post.setDelivery(delivery);
        post.setStatus("ONGOING");
        post.setUid(Integer.parseInt(uid));

        postService.insert(post);
        return "succeed";
    }

    @RequestMapping(value = "/saveUsername", method = RequestMethod.GET)
    public void saveUsername(HttpServletRequest request){
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        Account account = new Account();
        account.setId(Integer.parseInt(id));
        account.setUsername(username);
        loginService.updateUsernameByPrimaryKey(account);
    }

    @ResponseBody
    @RequestMapping(value = "/saveAvatar", method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
    public String saveAvatar(@RequestParam("img") MultipartFile file,
                           HttpServletRequest request) {
        String id = request.getParameter("id");
        String filePath = request.getSession().getServletContext().getRealPath("/upload");
        String newFileName = fileOperate(file,filePath);
        Account account = new Account();
        account.setAvatar(newFileName);
        account.setId(Integer.parseInt(id));
        loginService.updateAvatarByPrimaryKey(account);
        return newFileName;
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
    public String delete(HttpServletRequest request, HttpServletResponse response){
        Integer postId = Integer.parseInt(request.getParameter("postId"));
        postService.deleteByPrimaryKey(postId);
        return "succeed";
    }

    @RequestMapping(value = "/saveImg", method = RequestMethod.POST)
    public void saveImg1(@RequestParam("img1") MultipartFile file1,
                         @RequestParam("img2") MultipartFile file2,
                         @RequestParam("img3") MultipartFile file3,
                         @RequestParam("img4") MultipartFile file4,
                         @RequestParam("img5") MultipartFile file5,
                         @RequestParam("img6") MultipartFile file6,
                         @RequestParam("img7") MultipartFile file7,
                         @RequestParam("img8") MultipartFile file8,
                         @RequestParam("img9") MultipartFile file9,
                         HttpServletRequest request) {
        Post post = postService.select(request.getParameterMap());
        String file1name = file1.getOriginalFilename();
        String filePath = request.getSession().getServletContext().getRealPath("/upload");
        String newFileName = fileOperate(file1, filePath);
        post.setImage1(newFileName);
        if (!file2.getOriginalFilename().equals(file1name)) {
            newFileName = fileOperate(file2, filePath);
            post.setImage2(newFileName);
        }
        if (!file3.getOriginalFilename().equals(file1name)) {
            newFileName = fileOperate(file3, filePath);
            post.setImage3(newFileName);
        }
        if (!file4.getOriginalFilename().equals(file1name)) {
            newFileName = fileOperate(file4, filePath);
            post.setImage4(newFileName);
        }
        if (!file5.getOriginalFilename().equals(file1name)) {
            newFileName = fileOperate(file5, filePath);
            post.setImage5(newFileName);
        }
        if (!file6.getOriginalFilename().equals(file1name)) {
            newFileName = fileOperate(file6, filePath);
            post.setImage6(newFileName);
        }
        if (!file7.getOriginalFilename().equals(file1name)) {
            newFileName = fileOperate(file7, filePath);
            post.setImage7(newFileName);
        }
        if (!file8.getOriginalFilename().equals(file1name)) {
            newFileName = fileOperate(file8, filePath);
            post.setImage8(newFileName);
        }
        if (!file9.getOriginalFilename().equals(file1name)) {
            newFileName = fileOperate(file9, filePath);
            post.setImage9(newFileName);
        }
        postService.updateByPrimaryKey(post);
    }

    @ResponseBody
    @RequestMapping(value = "/getPost", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
    public String getPost(HttpServletRequest request, HttpServletResponse response) {
        String uid = request.getParameter("id");
        List<Post> posts;
        if (uid == null){
            posts = postService.selectTen(request.getParameterMap());
        } else {
            posts = postService.selectByUid(Integer.parseInt(uid));
        }
        return JSONObject.toJSONString(posts);
    }

    @ResponseBody
    @RequestMapping(value = "/getPostByStar", method = RequestMethod.GET, produces={"application/json; charset=UTF-8"})
    public String getPostByStar(HttpServletRequest request, HttpServletResponse response) {
        List<Post> posts;
        posts = postService.selectByStar(request.getParameterMap());
        return JSONObject.toJSONString(posts);
    }

    /*

    @RequestMapping("/register")
    public String toRegister() {
        return "register";
    }


    @RequestMapping("/helloworld")
    public String hello() {
        return "helloworld";
    }

    @RequestMapping("/weblogin")
    public String toLogin() {
        return "weblogin";
    }

     */
    private String fileOperate(MultipartFile file, String filePath) {
        String originalFileName = file.getOriginalFilename();
        System.out.println("原始:"+originalFileName);
        String newFileName = UUID.randomUUID() + originalFileName;
        System.out.println("新:" + newFileName);
        File targetFile = new File(filePath,newFileName);
        try {
            file.transferTo(targetFile);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFileName;
    }

}
