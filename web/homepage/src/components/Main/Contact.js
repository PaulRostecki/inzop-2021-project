import React, { useRef } from "react";
import emailjs from "@emailjs/browser";

const Contact = () => {
  const form = useRef();

  const sendEmail = (e) => {
    e.preventDefault();

    emailjs
      .sendForm(
        "service_nsgi6pd",
        "template_0mohjbg",
        form.current,
        "user_DjPYQTe1z2KVRnaOwCxGO"
      )
      .then(
        (result) => {
          console.log(result.text);
        },
        (error) => {
          console.log(error.text);
        }
      );
  };

  return (
    <section className="contact" id="contact">
      <h2>Kontakt</h2>
      <form ref={form} className="form-style" onSubmit={sendEmail}>
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
          <textarea name="message"></textarea>
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
