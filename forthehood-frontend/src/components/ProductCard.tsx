import {useContext} from "react"
import {CartContext} from "../context/CartContext"

function ProductCard({product}:any){

const {addToCart}=useContext(CartContext)

return(

<div className="border p-4 rounded hover:shadow">

<img
src={product.image}
className="h-40 w-full object-cover"
/>

<h2 className="font-bold mt-2">
{product.name}
</h2>

<p>${product.price}</p>

<button
onClick={()=>addToCart(product)}
className="bg-black text-white px-3 py-1 mt-2"
>

Add to cart

</button>

</div>

)

}

export default ProductCard