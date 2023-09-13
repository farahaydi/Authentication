# Authentication

in this lab I'm creating a database called AuthDataBase
and create 2 model 1- SiteUser to make the user enter the username and the password and in the AuthuntactionController we crete the Auntuntection using Bcrypt
where user signUp using username and password and the password will encrepted using Bcrypt and the data store in database
the in login This method handles the login process with a secret key. It checks if the provided username exists in the database and if the provided password matches the hashed password in the database. If the credentials are valid, it creates a session for the user, stores their username, and redirects them to a page with a secret content. If the login fails, the user is redirected back to the login page.
in logout I'm just ending the session 
the postController same as previous lab
This controller manages the routes for the home page and a page with secret content.

The getHomePage method returns the HTML page for the home page ("/").
The getHomePageWithSecret method retrieves the username from the user's session, adds it to the model, and returns a page that displays posts. This page is considered to have "secret" content accessible only to logged-in users.
