import React from "react";

const Contact = () => {
  const handleSubmit = () => {
    window.location.reload();
  };

  return (
    <section className="contact" id="contact" onSubmit={handleSubmit}>
      <h2>Kontakt</h2>
      <form action="" method="get" className="form-style">
        <label htmlFor="name">
          <span>Imię i nazwisko:</span>
          <input type="text" name="name" id="name" required />
        </label>
        <label htmlFor="email">
          <span>Adres e-mail:</span>
          <input type="email" name="email" id="email" required />
        </label>
        <label htmlFor="text">
          <span>Treść wiadomości:</span>
          <textarea></textarea>
        </label>
        <input
          type="submit"
          value="Wyślij"
          className="btn"
          style={{ cursor: "pointer" }}
        />
      </form>
    </section>
  );
};

export default Contact;
