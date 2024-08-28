type InputProps = {
    type: string,
    className: string,
    value: string | number,
    id: string,
    name: string,
    onChange: Function,
    placeholder: string,
    autoComplete?: string,
    autoFocus?: boolean
}

export default function Input({ type, className, value, id, name, onChange, placeholder, autoComplete, autoFocus = false }: InputProps) {
    return (
        <input type={type}
            className={className}
            value={value}
            id={id}
            name={name}
            onChange={(e) => onChange(e)}
            placeholder={placeholder}
            autoComplete={autoComplete}
            autoFocus={autoFocus}
        />
    )
}