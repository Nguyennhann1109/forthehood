import {products} from "../services/api"

function AdminDashboard(){

return(

<div className="p-10">

<h1 className="text-3xl font-bold">
Admin Dashboard
</h1>

<table className="mt-4 border">

<tr>
<th>ID</th>
<th>Name</th>
<th>Price</th>
</tr>

{products.map(p=>(

<tr key={p.id}>

<td>{p.id}</td>
<td>{p.name}</td>
<td>{p.price}</td>

</tr>

))}

</table>

</div>

)

}

export default AdminDashboard