import { Link } from "react-router-dom"

function Home(){

return(

<div className="p-10 text-center">

<h1 className="text-4xl font-bold">
For The Hood Store
</h1>

<p className="mt-4">
Streetwear fashion shop
</p>

<Link
to="/shop"
className="bg-black text-white px-4 py-2 mt-6 inline-block"
>

Go to Shop

</Link>

</div>

)

}

export default Home