package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        List<Post> olderPost = Post.find("order by postedAt desc").from(1).fetch(10);
        Post frontPost = Post.find("order by postedAt desc").first();
        //Logger.info("entro a la aplicación");
        render(frontPost, olderPost);
    }

}