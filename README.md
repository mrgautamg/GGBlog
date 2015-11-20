# GGBlog
Repository for EA Project

Completed all the use cases for Blog.

1. User with role "ROLE_CONTRIBUTOR" can add, edit blog and make comments.

2. User with role "ROLE_READER" can add comments.

3. User with role "ROLE_ADMIN" can add, edit blog and make comments, add Users.

4. Non users can read blog and also signup to become a member.

---------------------------------------------------------------------------------------------------------------------------------

Technologies Used.

1. Spring with hibernate.

2. Database based Security.

3. Tile for Menu.

4. Security tag library for authority control and for even generation of menu for different user, eg: edit controls are available only when the user is ADMIN.

5. tinymce an open source javascript plugin text editor.

6. Validations.

7. PRG and Session. etc.

----------------------------------------------------------------------------------------------------------------------

Setup Instruction:

1. Create Database GGBlog.

2. run project.

add roles to database :ROLE_CONTRIBUTOR,ROLE_READER,ROLE_ADMIN.

Databasae user name setting are following


 name="username" value="cs544" 
name="password" value="201511"

3. Now initially there may not be post when database is new so post can be added with a new sign up as contributor.

--------------------------------------------------------------------------------------------------------
