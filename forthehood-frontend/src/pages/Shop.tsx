import {products} from "../services/api"
import {useState} from "react"

import ProductCard from "../components/ProductCard"

function Shop(){

const [search,setSearch]=useState("")

const filtered=products.filter(p=>
p.name.toLowerCase().includes(search.toLowerCase())
)

return(

<div className="p-10">

<h1 className="text-3xl font-bold">
Shop
</h1>

<input
className="border p-2 mt-4"
placeholder="search..."
onChange={(e)=>setSearch(e.target.value)}
/>

<div className="grid grid-cols-3 gap-4 mt-4">

{filtered.map((p:any)=>(

<ProductCard
key={p.id}
product={p}
/>

))}

</div>

</div>

)

}

export default Shop