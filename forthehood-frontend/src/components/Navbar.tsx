import { Link } from "react-router-dom"

function Navbar(){

return(

<div className="bg-black text-white p-4 flex justify-between">

<h1 className="font-bold">
For The Hood
</h1>

<div className="flex gap-4">

<Link to="/">Home</Link>
<Link to="/shop">Shop</Link>
<Link to="/cart">Cart</Link>
<Link to="/login">Login</Link>

</div>

</div>

)

}

export default Navbar