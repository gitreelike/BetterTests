import SoundPlayer from './sound-player';

jest.mock('./sound-player'); // SoundPlayer is now a mock constructor

beforeEach(() => {
    // Clear all instances and calls to constructor and all methods:
    SoundPlayer.mockClear();
});

it('classes can be mocked by Jest', () => {
    // code under test
    const soundPlayer = new SoundPlayer(); // -> this is a jest mock now
    soundPlayer.playSoundFile('mySong');
    // end of code under test

    expect(SoundPlayer).toHaveBeenCalledTimes(1);
    expect(soundPlayer.playSoundFile).toHaveBeenCalledWith('mySong');
});