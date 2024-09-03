import { createContext, ReactNode, useContext, useEffect, useState } from "react"
import ApiService from "../service/ApiService";
import Category from "../models/Category";

type CategoryContextProps = {
    categories: Category[]
}

const CategoryContext = createContext<CategoryContextProps | undefined>(undefined);

export default function CategoryProvider({ children }: { children: ReactNode }) {
    let [categories, setCategories] = useState<Category[]>([]);

    useEffect(() => {
        const fetchCategories = async () => {
            let categories = await ApiService.call<Category[]>("api/categories", "GET");
            setCategories(categories.map((category) => {
                return new Category(category.getId(), category.getName());
            }));
        }
        fetchCategories();
    }, []);

    return (
        <CategoryContext.Provider value={{ categories }} >
            {children}
        </CategoryContext.Provider >
    )
}

export function useCategories(): CategoryContextProps {
    const context = useContext(CategoryContext);
    if (!context) {
        throw new Error("useCategories must be used within a CategoryProvider");
    }
    return context;
}
