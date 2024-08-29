export default class Utils {
    static getCategories(): string[] {
        return ["all", "chair", "double bed", "kitchen", "table"]; 
    }

    static getSortingOptions(): string[] {
       return ["name (ascending)", "name (descending)", "price (ascending)", "price (descending)", "newest"];
    }
}