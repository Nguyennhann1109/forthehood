import hero from "../assets/hero.png";
import "./hero.css";

export default function Hero(){
  return(
    <div className="hero">

      <img src={hero} className="hero-img"/>

      <div className="hero-overlay">
      </div>

    </div>
  )
}