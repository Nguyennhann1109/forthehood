import {useContext} from "react"
import {CartContext} from "../context/CartContext"

function Cart(){

const {cart,removeItem}=useContext(CartContext)

return(

<div className="p-10">

<h1 className="text-2xl font-bold">
Cart
</h1>

{cart.map((item:any)=>(

<div
key={item.id}
className="flex justify-between border p-2 mt-2"
>

<span>{item.name}</span>

<button
onClick={()=>removeItem(item.id)}
>

Remove

</button>

</div>

))}

</div>

)

}

export default Cart