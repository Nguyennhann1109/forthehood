function Pagination({ page,setPage,total }: any){

const perPage = 4
const pages = Math.ceil(total/perPage)

return(

<div className="flex gap-2 mt-6">

{Array.from({length:pages},(_,i)=>(

<button
key={i}
onClick={()=>setPage(i+1)}
className="border px-3 py-1 rounded"
>

{i+1}

</button>

))}

</div>

)

}

export default Pagination