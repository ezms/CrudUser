<h2>Yollo! As it's been a while since I posted anything here, I decided to create a project for a new stack (Java - Spring), 
it's a simple user CRUD, but with some features that I wanted to test.</h2>
***
### 🔚 Endpoints: 
<br>
<p style="color: gold">POST:</p>
<code>/register</code>
<br> 

#### Input
```json
{
	"username": "Glob",
	"email": "glob@mail.com",
	"password": "my dear password"
}
```

<br>

#### Output
<code style="color: green">200 OK</code>
```json
{
	"userId": "e6f48224-bcc5-4e08-86a6-2b64b7f6bb26",
	"username": "Glob",
	"email": "glob@mail.com"
}
```

<br>
<p style="color: lightblue">GET:</p>
<code>/users</code>
<br> 

#### Input
```json

```

<br>

#### Output
<code style="color: green">200 OK</code>
```json
[
    {
        "userId": "3d90797a-ad9e-425b-86d6-d912b18abc33",
        "username": "User 01",
        "email": "user01@mail.com"
    },
    {
        "userId": "e6f48224-bcc5-4e08-86a6-2b64b7f6bb26",
        "username": "Glob",
        "email": "glob@mail.com"
    }
]
```

<br>
<p style="color: lightblue">GET:</p>
<code>/users/{UUID}</code>
<br> 

#### Input
```json

```

<br>

#### Output
<code style="color: green">200 OK</code>
```json
{
    "userId": "e6f48224-bcc5-4e08-86a6-2b64b7f6bb26",
    "username": "Glob",
    "email": "glob@mail.com"
}
```

<br>
<p style="color: orange">PUT:</p>
<code>/users/{UUID}</code>
<br> 

#### Input
```json
{
    "username": "The Cooler Glob",
    "email": "cooler.glob@mail.com",
    "password": "my cooler password"
}
```

<br>

#### Output
<code style="color: green">200 OK</code>
```json
{
    "userId": "e6f48224-bcc5-4e08-86a6-2b64b7f6bb26",
    "username": "The Cooler Glob",
    "email": "cooler.glob@mail.com"
}
```

<br>
<p style="color: tomato">DELETE:</p>
<code>/users/{UUID}</code>
<br> 

#### Input
```json

```

<br>

#### Output
<code style="color: green">204 NO CONTENT</code>
```json
"No body returned for response"
```
