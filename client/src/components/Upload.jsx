import { useState } from "react";

const Upload = () => {
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  const [blogdata, setBlogdata] = useState([]);

  const uploadBlog = () => {
    fetch("https://spring-blog-latest-devk.onrender.com/api/blog", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ title, content }),
    })
      .then((response) => response.json())
      .then((data) => {
        setBlogdata(data);
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  };

  return (
    <>
      <h1>Blog Upload</h1>
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
      <p>
        <a href="/">Home</a>
      </p>
    </>
  );
};

export default Upload;
