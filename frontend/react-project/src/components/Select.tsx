type SelectProps = {
    className?: string,
    value: string | number,
    id: string,
    name: string,
    onChange: (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement | HTMLTextAreaElement>) => void,
    options: string[] | number[]
}

export default function Select({ className = "form-select", value, id, name, onChange, options }: SelectProps) {
    return (
        <select className={className}
            value={value}
            id={id}
            name={name}
            onChange={(e) => onChange(e)}
        >
            {options.map((option, index) => (
                <option key={index} value={option}>
                    {typeof option === "string"
                        ? option.charAt(0).toUpperCase() + option.slice(1).toLowerCase()
                        : option}
                </option>
            ))}
        </select>
    )
}