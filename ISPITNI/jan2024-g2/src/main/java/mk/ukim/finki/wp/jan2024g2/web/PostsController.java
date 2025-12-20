package mk.ukim.finki.wp.jan2024g2.web;

import mk.ukim.finki.wp.jan2024g2.model.PostType;

import java.time.LocalDate;
import java.util.List;

public class PostsController {
    /**
     * This method should use the "list.html" template to display all posts.
     * The method should be mapped on paths '/' and '/posts'.
     * The arguments that this method takes are optional and can be 'null'.
     * In the case when the arguments are not passed (both are 'null') all posts should be displayed.
     * If one, or both of the arguments are not 'null', the posts that are the result of the call
     * to the method 'filterPosts' from the PostsService should be displayed.
     *
     * @param tagId
     * @param postType
     * @return The view "list.html".
     */
    public String listAll(Long tagId, PostType postType) {
        return "";
    }

    /**
     * This method should display the "form.html" template.
     * The method should be mapped on path '/posts/add'.
     *
     * @return The view "form.html".
     */
    public String showAdd() {
        return "";
    }

    /**
     * This method should display the "form.html" template.
     * However, in this case, all 'input' elements should be filled with the appropriate value for the post that is updated.
     * The method should be mapped on path '/posts/edit/[id]'.
     *
     * @return The view "form.html".
     */
    public String showEdit(Long id) {
        return "";
    }

    /**
     * This method should create a new post given the arguments it takes.
     * The method should be mapped on path '/posts'.
     * After the post is created, all posts should be displayed.
     *
     * @return The view "list.html".
     */
    public String create(
            String title,
            String content,
            LocalDate dateCreated,
            PostType postType,
            List<Long> tags
    ) {
        return "";
    }

    /**
     * This method should update a post given the arguments it takes.
     * The method should be mapped on path '/posts/[id]'.
     * After the post is updated, all posts should be displayed.
     *
     * @return The view "list.html".
     */
    public String update(Long id,
                         String title,
                         String content,
                         LocalDate dateCreated,
                         PostType postType,
                         List<Long> tags
    ) {
        return "";
    }

    /**
     * This method should delete the application that has the appropriate identifier.
     * The method should be mapped on path '/posts/delete/[id]'.
     * After the post is deleted, all posts should be displayed.
     *
     * @return The view "list.html".
     */
    public String delete(Long id) {
        return "";
    }

    /**
     * This method should increase the number of likes of the appropriate post by 1.
     * The method should be mapped on path '/posts/like/[id]'.
     * After the operation, all posts should be displayed.
     *
     * @return The view "list.html".
     */
    public String like(Long id) {
        return "";
    }
}
