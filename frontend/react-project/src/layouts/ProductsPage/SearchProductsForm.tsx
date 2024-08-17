export default function SearchProductsForm() {
    function handleSubmit(e: React.FormEvent<HTMLFormElement>): void {
        e.preventDefault();
        console.log(searchParameters);
        //logic for searching products
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <div>

                </div>
                <div>

                </div>
                <div>

                </div>
                <div>

                </div>
                <button></button>
                <button></button>
            </form>
        </div>
    )
}