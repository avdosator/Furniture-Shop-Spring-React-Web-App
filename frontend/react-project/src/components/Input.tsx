type InputProps = {
    type: string,
    className: string,
    value: string | number,
    id: string,
    name: string,
    onChange: Function,
    placeholder: string,
    autoComplete: string,
    autofocus: boolean 
}

export default function Input({type, classname, value, id, name, onChange, placeholder, autoComplete, autoFocus }: InputProps) {
    return (
        <input type="text"
        className=""
        value={}
        id=""
        name=""
        onChange={}
        placeholder=""
        autoComplete=""
        autoFocus
         />
    )
}