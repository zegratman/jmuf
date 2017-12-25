# jmuf
## The Java MUsical Framework

Composing music by programming is hard. This framework gives the opportunity for programmers to define, from scratch, their music framework in which to compose.

JMUF is based on acoustic and physics theories. The goal is then to provide a Java representation of these theories to build typical musical compositions :
* Notes, Scales, Chords
* Alterations
* Modulations
* Envelopes
* Time, Tempo, Metrics
* Parts

At the moment, the project contains two Maven modules :
* **jmuf-core** : musical theory framework, based on pure physics and acoustic theories,
* **jmuf-classic** : classic sample implementation of the framework, where classical music definitions stand, as examples of the framework power

## v0.3.0 content (current SNAPSHOT)

- **jmuf-core**
  - Modulation definition
  - Modulated node definition
- **jmuf-classic**
  - Sample of note modulation : sinusoidal and squared modulation
  - Advanced classical note scale : pythagorean scale

## previous content
- **jmuf-core**
  - Note, Chord, Scale, sub-Scale, Interval definitions
  - Alteration definition
- **jmuf-classic**
  - Classical note scale : tempered scale
