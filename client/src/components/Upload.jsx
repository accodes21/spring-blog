import { useState } from "react";

const Upload = () => {
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  const [blogdata, setBlogdata] = useState([]);

  const uploadBlog = () => {
    fetch("http://localhost:8080/api/blog", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ title, content }),
    })
      .then((response) => response.json())
      .then((data) => {
        setBlogdata(data);
        // window.location.reload();
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  };

  return (
    <>
      <h2>Blog Upload</h2>
      <div className="upload">
        <input
          type="text"
          name="title"
          placeholder="Title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
        <textarea
          name="content"
          placeholder="Content"
          value={content}
          onChange={(e) => setContent(e.target.value)}
        />
        <button id="upload-button" onClick={uploadBlog}>
          Upload
        </button>
      </div>
    </>
  );
};

export default Upload;
