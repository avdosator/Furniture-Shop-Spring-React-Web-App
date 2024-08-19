import SearchProductsForm from "./SearchProductsForm";

export default function ProductsList() {
    return (
        <>
            <SearchProductsForm />
            <main className="mt-5">
                <h1 className="text-center">Products (88- this should represent number of products based on search parameters)</h1>
            </main>
        </>
    );
}