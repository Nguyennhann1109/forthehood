function CartItem({ item }: any) {

  return (
    <div className="flex justify-between border p-3 mb-3">

      <span>{item.name}</span>

      <span>${item.price}</span>

    </div>
  )
}

export default CartItem