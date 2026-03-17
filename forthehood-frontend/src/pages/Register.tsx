import { useState } from "react"
import { useNavigate } from "react-router-dom"

function Register(){

const navigate = useNavigate()

const [username,setUsername] = useState("")
const [password,setPassword] = useState("")

const handleRegister = (e:any) => {

e.preventDefault()

let users = JSON.parse(localStorage.getItem("users") || "[]")

const newUser = {
username,
password,
role:"user"
}

users.push(newUser)

localStorage.setItem("users",JSON.stringify(users))

alert("Register success")

navigate("/login")

}

return(

<div className="flex justify-center mt-20">

<form onSubmit={handleRegister} className="border p-6 w-80">

<h1 className="text-2xl mb-4">Register</h1>

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
Register
</button>

</form>

</div>

)

}

export default Register