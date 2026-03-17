import { createContext, useState } from "react"

export const AuthContext = createContext<any>(null)

export function AuthProvider({ children }: any) {

const [user,setUser] = useState<any>(null)

const login = (userData:any) => {
setUser(userData)
}

const logout = () => {
setUser(null)
}

return (

<AuthContext.Provider value={{user,login,logout}}>
{children}
</AuthContext.Provider>

)

}