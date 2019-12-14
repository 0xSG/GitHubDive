# GitHub Dive Searching application

## About
Android GITHUB Data fetching uisng RetroFit and MVVM. Tab1 - about the searched person. Tab2 - repository search with filters.

## Screen Shorts


## Dependencies

- https://github.com/hdodenhof/CircleImageView
- <https://github.com/bumptech/glide>
- RetroFit 2 for fetching data from GitHub

## Structure
- data : Contains Singleton classs which holds main data
- adapters : Contains all the adapters like recycler view adapters etc.
- model : Contains all blue prints classed of all data used and API, input for retrofit2
- searchtabs : Only contains modelview files of tabs in search
- viewmodel : Contains main view model files for MVVM.