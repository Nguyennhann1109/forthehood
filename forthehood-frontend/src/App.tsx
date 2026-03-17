import { BrowserRouter, Routes, Route } from "react-router-dom"

import Navbar from "./components/Navbar"

import Home from "./pages/Home"
import Shop from "./pages/Shop"
import Cart from "./pages/Cart"
import Login from "./pages/Login"
import Register from "./pages/Register"
import AdminDashboard from "./pages/AdminDashboard"

import { AuthProvider } from "./context/AuthContext"
import { CartProvider } from "./context/CartContext"

function App() {

return (

<AuthProvider>

<CartProvider>

<BrowserRouter>

<Navbar/>

<Routes>

<Route path="/" element={<Home/>}/>
<Route path="/shop" element={<Shop/>}/>
<Route path="/cart" element={<Cart/>}/>
<Route path="/login" element={<Login/>}/>
<Route path="/register" element={<Register/>}/>
<Route path="/admin" element={<AdminDashboard/>}/>

</Routes>

</BrowserRouter>

</CartProvider>

</AuthProvider>

)

}

export default App