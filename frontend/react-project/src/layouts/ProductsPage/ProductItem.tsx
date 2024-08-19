import Category from "../../models/Category"

type ProductItemProps = {
    id: number,
    name: string,
    price: number,
    stock:number,
    description: string,
    category: Category
}

export default function ProductItem({id, name, price, stock, description, category}: ProductItemProps) {
    return (
        <>
            <h1>{name} - {price}</h1>
            <h3>{description}</h3>
            <h4>{category.getName()}</h4>
            
        </>
    )
}