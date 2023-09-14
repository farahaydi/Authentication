# Authentication

SiteUser:

Model class representing users.
It has an ID, username, password, and a list of posts associated with it.
The constructor allows for setting the username and password.
AuthenticationController:

Manages user authentication.
Handles signup, login, and logout.
Utilizes BCrypt to hash passwords during signup and check passwords during login.
PostController:

Manages posts and routes.
Allows users to add posts.
Retrieves posts for display.
Post:

Model class representing posts.
It has an ID, text content, and a reference to the user who created the post.
Repositories:

PostRepository and SiteUserRepository extend JpaRepository for handling database operations.
SiteUserRepository:

Provides a method to find a user by their username.