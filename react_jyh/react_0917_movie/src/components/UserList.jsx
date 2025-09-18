import React from "react";
const UserList = ({ users }) => {
  return (
    <div>
      {users.map((user) => {
        return (
          <div className="card mb-2">
            {" "}
            <div className="card-body">{user.name}</div>
          </div>
        );
      })}
    </div>
  );
};
export default UserList;
