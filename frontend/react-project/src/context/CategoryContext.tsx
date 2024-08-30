import { createContext, ReactNode } from "react"

type CategoryContextProps = {
    categories: {
        id: number,
        name: string
    }
}

const CategoryContext = createContext<CategoryContextProps | undefined>(undefined);

export default function CategoryProvider({children}: {children: ReactNode}) {
    return (

    )
}