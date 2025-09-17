import React from "react";

const InputField = ({ type, value, placeholder, onChange, errorMessage }) => {
  return (
    <div>
      <input
        type={type}
        placeholder={placeholder}
        value={value}
        onChange={onChange}
      />
      <br />
      <div style={{ color: "red" }}>{errorMessage}</div>
    </div>
  );
};

export default InputField;
