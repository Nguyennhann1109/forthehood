import {createContext,useState} from "react"

export const CartContext=createContext<any>(null)

export function CartProvider({children}:any){

const [cart,setCart]=useState<any[]>([])

const addToCart=(product:any)=>{

setCart([...cart,product])

}

const removeItem=(id:number)=>{

setCart(cart.filter(i=>i.id!==id))

}

return(

<CartContext.Provider value={{cart,addToCart,removeItem}}>

{children}

</CartContext.Provider>

)

}