import { useState, useContext } from "react"
import { useNavigate } from "react-router-dom"
import { AuthContext } from "../context/AuthContext"

function Login(){

const {login} = useContext(AuthContext)

const navigate = useNavigate()

const [username,setUsername] = useState("")
const [password,setPassword] = useState("")

const handleLogin = (e:any) => {

e.preventDefault()

let users = JSON.parse(localStorage.getItem("users") || "[]")

// thêm admin mặc định
const admin = {
username:"admin",
password:"123",
role:"admin"
}

users.push(admin)

const user = users.find(
(u:any)=>u.username===username && u.password===password
)

if(user){

login(user)

alert("Login success")

navigate("/")

}else{

alert("Wrong account")

}

}

return(

<div className="flex justify-center mt-20">

<form onSubmit={handleLogin} className="border p-6 w-80">

<h1 className="text-2xl mb-4">Login</h1>

<input
className="border p-2 w-full mb-3"
placeholder="Username"
onChange={(e)=>setUsername(e.target.value)}
/>

<input
type="password"
className="border p-2 w-full mb-3"
placeholder="Password"
onChange={(e)=>setPassword(e.target.value)}
/>

<button className="bg-black text-white w-full py-2">
Login
</button>

</form>

</div>

)

}

export default Login