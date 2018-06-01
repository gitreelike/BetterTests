import createMockInstance from 'jest-create-mock-instance';
import SoundPlayer from './sound-player';

it('Soundplayer can be mocked using a lib', () => {
    const soundPlayer = createMockInstance(SoundPlayer);

    soundPlayer.playSoundFile('mySong');

    expect(soundPlayer.playSoundFile).toHaveBeenCalledTimes(1);
    expect(soundPlayer.playSoundFile).toHaveBeenCalledWith('mySong');
});