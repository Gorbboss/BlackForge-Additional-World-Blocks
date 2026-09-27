# BlackForge Additional World Blocks

Forge 1.20.1 development project based on the MIT-licensed Even Better Nether
1.3.1 release by Autumnly24. The upstream baseline is being reconstructed and
validated before the namespace is migrated and additional content is added.

The current selective BetterNether port is dependency-free: it does not require
BCLib, WunderLib, or BetterNether at runtime. Imported construction blocks,
stalactites, plants, vines, and the restricted willow set are implemented in
staged commits so each batch can be verified by GitHub Actions.

Current verification includes the dependency-free imported registries and their
explicit creative-tab population.

See [NOTICE.md](NOTICE.md) for upstream attribution.
