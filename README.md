# Chat Application with Spring Boot, JWT, and Spring Security

<h2>Overview</h2>
<p>
    This is a RESTful chat application built with <strong>Spring Boot</strong> that allows users to register, log in, and exchange messages in real-time. The application is secured using <strong>JWT (JSON Web Tokens)</strong> for authentication and <strong>Spring Security</strong> for authorization.
</p>

<h2>Features</h2>
<ul>
    <li>User Registration and Login with JWT authentication.</li>
    <li>Secure message exchange between users.</li>
    <li>Messages are associated with sender and receiver information.</li>
    <li>Spring Security handles user authentication and access control.</li>
    <li>MySQL database used to store users and chat messages.</li>
</ul>

<h2>Technologies Used</h2>
<ul>
    <li><strong>Spring Boot</strong> - Backend framework.</li>
    <li><strong>Spring Security</strong> - For authentication and authorization.</li>
    <li><strong>JWT (JSON Web Tokens)</strong> - For stateless authentication.</li>
    <li><strong>Spring Data JPA</strong> - For database interaction.</li>
    <li><strong>MySQL</strong> - Relational database.</li>
</ul>

<h2>Getting Started</h2>

<h3>Prerequisites</h3>
<p>Before you begin, ensure you have the following installed:</p>
<ul>
    <li><strong>Java 11+</strong></li>
    <li><strong>Maven</strong></li>
    <li><strong>MySQL</strong> (or any relational database)</li>
</ul>

<h3>Installation and Setup</h3>
<ol>
    <li>Clone the repository:
        <pre><code>git clone https://github.com/your-username/chat-application.git</code></pre>
    </li>
    <li>Navigate to the project directory:
        <pre><code>cd chat-application</code></pre>
    </li>
    <li>Open <strong>src/main/resources/application.properties</strong> and configure your database:
        <pre><code>
spring.datasource.url=jdbc:mysql://localhost:3306/chatdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
jwt.secret=mysecretkey
        </code></pre>
    </li>
    <li>Create the database in MySQL:
        <pre><code>CREATE DATABASE chatdb;</code></pre>
    </li>
    <li>Build and run the application:
        <pre><code>mvn spring-boot:run</code></pre>
    </li>
</ol>

<h3>Running the Application</h3>
<p>Once the application is running, it will be available on <strong>http://localhost:8080</strong>.</p>

<h4>API Endpoints</h4>
<ul>
    <li><strong>POST</strong> <code>/auth/register</code> - Register a new user.</li>
    <li><strong>POST</strong> <code>/auth/login</code> - Authenticate a user and get a JWT.</li>
    <li><strong>POST</strong> <code>/chat/send</code> - Send a message to another user (requires JWT).</li>
    <li><strong>GET</strong> <code>/chat/messages</code> - Retrieve chat history for the authenticated user (requires JWT).</li>
</ul>

<h4>Sample JSON for Registration</h4>
<pre><code>
{
  "username": "john",
  "password": "password123"
}
</code></pre>

<h4>Sample JSON for Sending a Message</h4>
<pre><code>
{
  "content": "Hello, how are you?",
  "receiverUsername": "alice"
}
</code></pre>

<h3>Authentication with JWT</h3>
<p>When a user successfully logs in using the <code>/auth/login</code> endpoint, the server responds with a JWT. This token should be included in the header of every subsequent request to secure endpoints (e.g., sending or fetching messages).</p>

<p>For example, add the following header:</p>
<pre><code>Authorization: Bearer your-jwt-token</code></pre>

<h2>Architecture</h2>
<p>The chat application follows a layered architecture:</p>
<ul>
    <li><strong>Controller Layer</strong>: Handles HTTP requests and responses.</li>
    <li><strong>Service Layer</strong>: Contains the business logic and interacts with repositories.</li>
    <li><strong>Repository Layer</strong>: Manages data persistence using JPA and interacts with the database.</li>
</ul>

<h3>Database Schema</h3>
<p>The application uses two tables:</p>
<ol>
    <li><strong>Users</strong>:
        <ul>
            <li><code>id</code>: Auto-generated user ID.</li>
            <li><code>username</code>: Unique username.</li>
            <li><code>password</code>: Encrypted user password.</li>
        </ul>
    </li>
    <li><strong>Chat Messages</strong>:
        <ul>
            <li><code>id</code>: Auto-generated message ID.</li>
            <li><code>content</code>: Text content of the message.</li>
            <li><code>sender_id</code>: ID of the user who sent the message.</li>
            <li><code>receiver_id</code>: ID of the user who received the message.</li>
            <li><code>timestamp</code>: When the message was sent.</li>
        </ul>
    </li>
</ol>

<h2>Security</h2>
<p>The application uses <strong>Spring Security</strong> to secure user registration, login, and messaging functionalities:</p>
<ul>
    <li>All endpoints, except for <code>/auth/register</code> and <code>/auth/login</code>, are secured and require a valid JWT token.</li>
    <li>Passwords are stored in an encrypted format using BCrypt.</li>
    <li>JWT tokens are used to authorize users for accessing protected endpoints.</li>
</ul>

<h2>Testing the API</h2>
<p>You can test the API using tools like <strong>Postman</strong> or <strong>cURL</strong>. Here's an example of using cURL to test the login functionality:</p>
<pre><code>
curl -X POST http://localhost:8080/auth/login -H "Content-Type: application/json" -d '{
  "username": "john",
  "password": "password123"
}'
</code></pre>

<p>This will return a JWT token which can then be used to access the secure <code>/chat/send</code> and <code>/chat/messages</code> endpoints.</p>

<h2>Contributing</h2>
<p>If you'd like to contribute to the project, feel free to submit a pull request or open an issue on the GitHub repository. All contributions are welcome!</p>

<h2>License</h2>
<p>This project is licensed under the MIT License.</p>

</body>
</html>
