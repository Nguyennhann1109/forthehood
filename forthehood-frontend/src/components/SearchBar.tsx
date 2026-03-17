function SearchBar({ setSearch }: any) {

  return (

    <input
      placeholder="Search product..."
      className="border p-2 w-full mt-4 rounded"
      onChange={(e)=>setSearch(e.target.value)}
    />

  )

}

export default SearchBar